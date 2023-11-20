package com.project.parking.repository.impl;

import com.project.parking.entity.ParkingTicket;
import com.project.parking.repository.ParkingTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
@RequiredArgsConstructor
public class ParkingTicketRepositoryImpl implements ParkingTicketRepository {
    private final EntityManager entityManager;
    @Override
    public void saveAndFlush(ParkingTicket parkingTicket) {
        entityManager.createNativeQuery("INSERT INTO t_parking_ticket (id, licence_plate, id_admin, id_type, paid, entry_time) values (?,?,?,?,?,?)")
                .setParameter(1, UUID.randomUUID())
                .setParameter(2, parkingTicket.getLicencePlate())
                .setParameter(3, parkingTicket.getAdmin().getId())
                .setParameter(4, parkingTicket.getType().getId())
                .setParameter(5, parkingTicket.getPaid())
                .setParameter(6, parkingTicket.getEntryTime())
                .executeUpdate();
        entityManager.flush();
    }

    @Override
    public ParkingTicket getByLicencePlate(String licencePlate) {
        return (ParkingTicket) entityManager.createNativeQuery("SELECT * FROM t_parking_ticket WHERE licence_plate = ? AND paid = false", ParkingTicket.class)
                .setParameter(1, licencePlate)
                .setMaxResults(1)
                .getSingleResult();
    }

    @Override
    public ParkingTicket update(ParkingTicket parkingTicket) {
        return null;
    }

    @Override
    public List findAllPaidOrNoPaid(Boolean paid) {
        return entityManager.createNativeQuery("SELECT * FROM t_parking_ticket WHERE paid = ?", ParkingTicket.class)
                .setParameter(1, paid)
                .getResultList();
    }
}
