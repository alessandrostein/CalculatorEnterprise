/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator.ejbs.interfaces;

import javax.ejb.Local;

/**
 *
 * @author alessandro.stein
 */
@Local
public interface CalculatorBeanLocal {
    double somar (double a, double b);
}
