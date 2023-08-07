package spring

import org.springframework.beans.factory.support.BeanDefinitionRegistry
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner
import org.springframework.core.type.filter.AnnotationTypeFilter

class CustomScanner(private val registry: BeanDefinitionRegistry) : ClassPathBeanDefinitionScanner(registry) {
    constructor(registry: BeanDefinitionRegistry, annoType: Class<out Annotation>) : this(registry) {
        super.addIncludeFilter(AnnotationTypeFilter(annoType))
    }

    override fun scan(vararg basePackages: String?): Int {
        return super.scan(*basePackages)
    }
}