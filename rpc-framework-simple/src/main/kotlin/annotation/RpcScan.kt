package annotation

@Target(AnnotationTarget.TYPE,AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
//@Import
annotation class RpcScan(val basePackage:Array<String>)
