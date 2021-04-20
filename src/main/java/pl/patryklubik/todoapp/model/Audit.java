package pl.patryklubik.todoapp.model;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;


/**
 * Create by Patryk Łubik on 19.04.2021.
 */

@Embeddable
public class Audit {


    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;



    @PrePersist
        // odpali się tuż przed zapisem do bazy danych
    void prePersist() {

        createdOn = LocalDateTime.now();
    }

    @PreUpdate
        // włącza się tuż przed aktualizacji w bazie danych
    void preMarge() {

        updatedOn = LocalDateTime.now();
    }

}
