package com.parcel.model.domain.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "Destinations")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassDestination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DESTINATION_ID", nullable = false)
    private Long id;

    @Column(name = "DESTINATION_COUNTRY", nullable = false)
    private String country;

    @Column(name = "DESTINATION_CITY", nullable = false)
    private String city;

    @Column(name = "DESTINATION_ADDRESS", nullable = false)
    private String streetAddress;

    @OneToMany(mappedBy = "destination")
    private List<ClassShipment> shipments;
}
