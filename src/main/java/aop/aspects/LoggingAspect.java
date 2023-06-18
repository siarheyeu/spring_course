package aop.aspects;


import aop.Book;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {

//    @Pointcut("execution(* aop.UniLibrary.*(..))")
//    private void allMethodsFromUniLibrary() {
//    }
//
//    @Pointcut("execution(public void aop.UniLibrary.returnMagazine())")
//    private void returnMagazineFromUniLibrary(){
//    }
//
//    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
//    private void allMethodsExceptReturnMagazineFromUniLibrary(){
//    }
//
//    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
//    public void beforeAllMethodsExceptReturnMagazineAdvice(){
//        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: Log #10");
//    }


//    @Pointcut("execution (* aop.UniLibrary.get*()")
//    private void allGetMethodsFromUniLibrary(){
//    }
//
//    @Pointcut("execution (* aop.UniLibrary.return*()")
//    private void allReturnMethodsFromUniLibrary(){
//    }
//
//
//    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
//    private void allGetAndReturnMethodsFromUniLibrary(){
//        }
//
//
//    @Before("allGetMethodsFromUniLibrary()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetLoggingAdvice: writing Log #1");
//    }
//
//    @Before("allReturnMethodsFromUniLibrary()")
//    public void beforeReturnLoggingAdvice(){
//        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
//    }
//
//    @Before("allGetAndReturnMethodsFromUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice(){
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log #3");
//    }

      @Before("aop.aspects.MyPointcuts.allAddMethods(JoinPoint joinPoint)")
    public void beforeAddLoggingAdvice() {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("MethodSignature = "
                + MethodSignature);
        System.out.println("MethodSignature.getMethod() = "
                + MethodSignature.getMethod());
        System.out.println("MethodSignature.getReturnType() = "
                + MethodSignature.getReturnType());
        System.out.println("MethodSignature.getName() = "
                  + MethodSignature.getName());

    if(methodSignature.getName().equals("addBook")){
        Object[] arguments = joinPoint.getArgs();
        for (Object obj: arguments) {
            if (obj instanceof Book){
                Book myBook = (Book) obj;
                System.out.println("Информация о книге: название - " +
                        myBook.getName() + ", автор - " + myBook.getAuthor() +
                        ", год издания - " + myBook.getYearOfPublication());
            }
            else if(obj instanceof String){
                System.out.println("Книгу в библиотеку добавляет " + obj);
            }
        }
    }
        System.out.println("beforeGetLoggingAdvice: логирование " + "попытки получить книгу/журнал");
        System.out.println("--------------------------------------");
    }

}
