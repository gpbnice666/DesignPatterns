什么是spring的事务传播性？
事务的传播性就是,事务中还包含另外的事务(事务嵌套),事务之间是怎么相互影响,然后如何执行的,这就是事务传播性

spring事务的传播行为的设置

public class ServiceA{
	@Transactional(propagation=Propagation.REQUIRED)
	public void methodA(){
		....
	}
}

七个事务传播属性
	PROPAGETION_REQUIRED(propagetion_required)  --支持当前事务,如果当前没有事务,就新建一个事务
	PROPAGETION_SUPPORTS(propagation_supports)  --支持当前事务,如果没有当前事务,就以非事务的方式执行
	PROPAGETION_MANDATORY(propagetion_mandatory)--支持当前事务,如果当前没有事务,就抛出异常
	PROPAGETION_REQUIREs_NEW(propagetion_requires_new) -- 新建事务,如果当前存在事务,就把当前事务挂起
	PRORPAGETION_NOT_SUPPRTS(propagation_not_supprts) --以事务的方式执行,如果当前存在事务,就把当前事务挂起
	PRORPAGETION_NEVER(propagation_never) --以非事务方式执行,如果当前存在事务,则抛出异常
	PRORPAGETION_NESTED(propagation_nested) --如果当前存在事务,则嵌套事务内执行,如果当前没有事务,如果当前没有事务，则进行与PROPAGATION_REQUIRED类似的操作。
	
	详细：
		1.REQUIRED
			加入当前正要执行的事务如果当前没有事务,那么就会起一个新事务
			比如：
				ServiceB.methodB()中的事务级别定义为REQUIRED,那么由于执行ServiceA.methodA()已经起了
				事务,这时调用ServiceB.methodB(),ServiceB.methodB()看到自己已经运行在ServiceA.methodA()的事务内部,
				就不会在起新的事务,假如Service.methodA()运行的时候发现自己没有在事务中,他就会为自己分配一个事务
				这样,ServiceA.methodA()或者在ServiceB.methodB()内的任何地方出现异常,事务都会回滚给,即使ServiceB.methodB()
				的事务已经被提交,但是ServiceA.methodA()fail要回滚,ServiceB.methodB也要回滚
		
		2.SUPPORS
			如果当前在事务中,即以事务的形式运行,如果当前不在一个事务中,则就以事务的方式执行
		
		3.MANDATORY
			必须在一个事务下运行,也就是说,他只能被一个父事务调用,否则抛出异常
		4.REQUIRES_NEW
			新建事务,如果当前存在事务,就把当前事务挂起
			比如：
				ServiceA.methodA的事务级别为REQURED,ServiceB.methodB的事务是REQUIRES_NEW,
				那么当执行ServiceB.methodB的时候,会把SericeA.methodA所在的事务就会挂起,
				ServiceB.methodB会起一个新的事务,等待SericeB.methodB的事务完成以后,
				他才继续执行,
				REQUIRES_NEW与REQURED的区别:
					事务的滚回成都不一样
					因为ServiceB.methodB是新起一个事务,那么就是存在两不同的事务,
					如果ServiceB.methodB的事务已经提交,那么ServiceA.methodA失败回滚,ServiceB.methodB是不会回滚的,
					如果ServiceB.methodB失败回滚,如果他抛出的异常被ServiceA.methodA捕获,ServiceA.methodA事务仍然可能提交
		5.NOT_SUPPORTED
			当前不支持事务，比如ServiceA.methodA的事务级别是REQUIRED,而ServiceB.methodB的事务级别还是NOT_SUPPORTED
			那么当执行到ServiceB.methodB时,ServiceA.methodA的事务挂起,而他以非事务的状态运行完,咋继续ServiceA.methodA的事务
			
				
		6.NEVER
			不能在事务中运行,假如ServiceA.methodA的事务级REQUIRED,而SerivceB.methodB的事务是NEVER
			那么ServiceB.methodB就有抛出异常
		7： NESTED

			理解Nested的关键是savepoint。他与REQUIRES_NEW的区别是，REQUIRES_NEW另起一个事务，将会与他的父事务相互独立，
			而Nested的事务和他的父事务是相依的，他的提交是要等和他的父事务一块提交的。也就是说，
		总的来说

1.当事务中方法中还有事务的时候，多事务是如何相互影响，如何去执行的，spring的事务传播性就规定了细节，例如如何回滚问题，7中传播级别。

2.A事务中有B事务，要考虑A，B事务如何执行，A中只需要考虑有没有事务就ok，B的话就需要具体看是那种事务传播性了		
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				