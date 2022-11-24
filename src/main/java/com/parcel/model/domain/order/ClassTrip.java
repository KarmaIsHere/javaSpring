package com.parcel.model.domain.order;

import com.parcel.model.domain.ClassTruck;
import com.parcel.model.domain.user.ClassUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Data
@Entity(name = "Trips")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRIP_ID", nullable = false)
    private Long id;

    @Column(name = "TRIP_START", nullable = false)
    private Timestamp start;

    @Column(name = "TRIP_END", nullable = false)
    private Timestamp end;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private ClassUser driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRUCK_ID", nullable = false)
    private ClassTruck truck;

    @OneToMany(mappedBy = "trip")
    private List<ClassStopPoint> stopPoints;


}
