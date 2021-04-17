package pl.patryklubik.todoapp.controller;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.patryklubik.todoapp.TaskConfigurationProperties;


/**
 * Create by Patryk Łubik on 17.04.2021.
 */
@RestController
class InfoController {

    private DataSourceProperties dataSource;
    private TaskConfigurationProperties myProp;

    InfoController(final DataSourceProperties dataSource, final TaskConfigurationProperties myProp) {
        this.dataSource = dataSource;
        this.myProp = myProp;
    }

    @GetMapping("info/url")
    String url() {
        return dataSource.getUrl();
    }

    @GetMapping("info/prop")
    boolean myProp() {
        return myProp.getTemplate().isAllowMultipleTasks();
    }
}