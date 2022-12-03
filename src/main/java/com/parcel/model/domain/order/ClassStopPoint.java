package com.parcel.model.domain.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity(name = "StopPoints")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassStopPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOPPOINT_ID", nullable = false)
    private Long id;

    @Column(name = "STOPPOINT_NR", nullable = false)
    private int nr;

    @Column(name = "STOPPOINT_TIME")
    private LocalDate stopDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SHIPMENT_ID", nullable = false)
    private ClassShipment shipment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRIP_ID", nullable = false)
    private ClassTrip trip;

}
