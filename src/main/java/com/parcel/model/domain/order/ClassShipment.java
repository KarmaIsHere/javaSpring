package com.parcel.model.domain.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@Entity(name = "Shipments")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassShipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHIPMENT_ID", nullable = false)
    private Long id;
    @Column(name = "SHIPMENT_STATUS")
    private ShipmentStatus status;

    @Column(name = "SHIPMENT_DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "SHIPMENT_WEIGHT", nullable = false)
    private String weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DESTINATION_ID")
    private ClassDestination destination;

    @OneToMany(mappedBy = "shipment")
    private List<ClassStopPoint> stopPoints;

}
