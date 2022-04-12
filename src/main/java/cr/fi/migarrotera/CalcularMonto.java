package cr.fi.migarrotera;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class CalcularMonto implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        int monto = Integer.parseInt((String) delegateExecution.getVariable("monto"));
        int salario = Integer.parseInt((String) delegateExecution.getVariable("salario"));
        int calculo = (80*salario)/100;
        String estado;

        if(calculo< monto){
            estado = "declinado";
        }else{
            estado = "aprobado";
        }

        delegateExecution.setVariable("estado", estado);


        System.out.println("El monto calculado es: " + monto+" "+salario );
    }
}
