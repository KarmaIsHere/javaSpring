package com.parcel.model.domain.order;

import com.parcel.model.domain.ClassTruck;
import com.parcel.model.domain.user.ClassUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
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

    @Column(name = "TRIP_START")
    private LocalDate start;

    @Column(name = "TRIP_END")
    private LocalDate end;

    @Column(name = "DEADLINE", nullable = false)
    private LocalDate deadline;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private ClassUser driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRUCK_ID")
    private ClassTruck truck;

    @OneToMany(mappedBy = "trip")
    private List<ClassStopPoint> stopPoints;


}
