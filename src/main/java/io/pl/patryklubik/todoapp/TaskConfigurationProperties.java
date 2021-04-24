package io.pl.patryklubik.todoapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * Create by Patryk Łubik on 17.04.2021.
 */

@Configuration
@ConfigurationProperties("task")
public class TaskConfigurationProperties {

    private Template template;

    TaskConfigurationProperties(final Template template) {
        this.template = template;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(final Template template) {
        this.template = template;
    }


    @Configuration
    public static class Template {
        private boolean allowMultipleTasks;

        public boolean isAllowMultipleTasks() {
            return allowMultipleTasks;
        }

        public void setAllowMultipleTasks(final boolean allowMultipleTasks) {
            this.allowMultipleTasks = allowMultipleTasks;
        }
    }


}
