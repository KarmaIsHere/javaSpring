package com.parcel.model.domain;

import com.parcel.model.domain.order.ClassTrip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "Trucks")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassTruck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRUCK_ID", nullable = false)
    private Long id;

    @Column(name = "TRUCK_BRAND", nullable = false)
    private String brand;

    @Column(name = "TRUCK_YEAR", nullable = false)
    private String year;

    @Column(name = "TRUCK_HEIGHT", nullable = false)
    private String height;

    @Column(name = "TRUCK_WEIGHT", nullable = false)
    private String weight;

    @Column(name = "STATUS", nullable = false)
    private TruckStatus status;

    @OneToMany(mappedBy = "truck")
    private List<ClassTrip> trips;

}
