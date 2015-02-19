package br.com.caelum.vraptor.interceptor;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.annotation.Log;
import br.com.caelum.vraptor.controller.ControllerMethod;

@AcceptsWithAnnotations(Log.class)
@Intercepts
public class LogInterceptor {

    private final ControllerMethod controllerMethod;

    @Inject
    public LogInterceptor(ControllerMethod controllerMethod) {
        this.controllerMethod = controllerMethod;
    }

    public LogInterceptor() {
        this(null); // para uso do CDI
    }

    @BeforeCall
    public void before() {
        String nomeDoMetodo = controllerMethod.getMethod().getName();
        System.out.println("Executando o método: " + nomeDoMetodo);
    }
    
    /*@Accepts
    public boolean accepts() {
        return controllerMethod.containsAnnotation(Log.class);
    }*/
}