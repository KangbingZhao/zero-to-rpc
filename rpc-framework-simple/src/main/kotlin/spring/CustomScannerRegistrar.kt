package spring

import annotation.RpcScan
import annotation.RpcService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.support.BeanDefinitionRegistry
import org.springframework.context.ResourceLoaderAware
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar
import org.springframework.core.annotation.AnnotationAttributes
import org.springframework.core.io.ResourceLoader
import org.springframework.core.type.AnnotationMetadata
import org.springframework.core.type.StandardAnnotationMetadata
import org.springframework.stereotype.Component

class CustomScannerRegistrar(private val resourceLoader: ResourceLoader?) : ImportBeanDefinitionRegistrar,
    ResourceLoaderAware {

    companion object {

        private val logger: Logger = LoggerFactory.getLogger(CustomScannerRegistrar::class.java)

        private const val BASE_PACKAGE_ATTRIBUTE_NAME = "basePackage"
        private const val SPRING_BEAN_BASE_PACKAGE = "cn.zhaokangbing.zerotorpc"
    }

    override fun setResourceLoader(resourceLoader: ResourceLoader?) {
        this.setResourceLoader(resourceLoader)
    }

    override fun registerBeanDefinitions(
        annotationMetadata: AnnotationMetadata,
        registry: BeanDefinitionRegistry
    ) {
        val annotationAttributes =
            AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(RpcScan::class.qualifiedName))
        val rpcBasePackages =
            annotationAttributes?.getStringArray(BASE_PACKAGE_ATTRIBUTE_NAME)?.takeIf { it.isNotEmpty() }
                ?: arrayOf((annotationMetadata as StandardAnnotationMetadata).introspectedClass.packageName)

        val rpcServiceScanner = CustomScanner(registry, RpcService::class.java)
        val beanRpcScanner = CustomScanner(registry, Component::class.java)

        if (resourceLoader != null) {
            rpcServiceScanner.resourceLoader = resourceLoader
            beanRpcScanner.resourceLoader = resourceLoader
        }

        rpcServiceScanner.scan(*rpcBasePackages).also {
            logger.info("rpcServiceScanner扫描数量:$it")
        }

        beanRpcScanner.scan(SPRING_BEAN_BASE_PACKAGE).also {
            logger.info("beanRpcScanner扫描数量:$it")
        }
    }
}