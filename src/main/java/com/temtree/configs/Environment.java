/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.configs;

/**
 *
 * @author admin
 */

import java.util.Properties;

public class Environment {

    public enum ProcessType {
        PAY_GATE, APP_IN_APP, PAY_POS, PAY_QUERY_STATUS, PAY_REFUND, PAY_CONFIRM;

        public String getSubDir(Properties prop) {
            return prop.getProperty(this.toString());
        }
    }


}
