/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abdi.formulario.locator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 *
 * @author Rogerio.Rodrigues
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, METHOD})
public @interface Locator {
    
}
