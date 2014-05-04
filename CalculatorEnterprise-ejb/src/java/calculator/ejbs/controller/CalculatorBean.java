/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator.ejbs.controller;

import calculator.ejbs.interfaces.CalculatorBeanLocal;
import javax.ejb.Stateless;

/**
 *
 * @author alessandro.stein
 */
@Stateless
public class CalculatorBean implements CalculatorBeanLocal {

    @Override
    public double somar(double a, double b) {
        return (a + b);
    }
}
