package com.example.marco.floor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.marco.floorbeacon.FloorBeaconRepository;
import com.example.marco.floorfile.FloorFileRepository;

public class FloorServiceTest {

    private FloorController floorController;
    private FloorService floorService;
    private FloorRepository floorRepository;
    private FloorBeaconRepository floorBeaconRepository;
    private FloorFileRepository floorFileRepository;
    
    @BeforeEach
    void setUp(){
        floorRepository = mock(FloorRepository.class);
        FloorEntity floorEntity = new FloorEntity("HM3", 56.7, 35.2, 270.0, 3);
        FloorEntity expectedFloorEntity = new FloorEntity(10L, "HM3", 56.7, 35.2, 270.0, 3);
        when(floorRepository.save(floorEntity)).thenReturn(expectedFloorEntity);
        floorBeaconRepository = mock(FloorBeaconRepository.class);
        floorFileRepository = mock(FloorFileRepository.class);

        floorService = new FloorService(floorRepository, floorBeaconRepository, floorFileRepository);
        System.out.println("Called before every test");
    }

    @Test
    public void sanityTest(){
        System.out.println("Sanity test");
        assertEquals(12, 10 + 2);
    }

    @Test
    public void givenFloorWithExplicitFloorId_whenAddFloor_thenThrowException(){
        FloorEntity floorEntity = new FloorEntity(1L, "HM3", 56.7, 35.2, 270.0, 3);
        Exception exception = null;
        
        try {
            floorService.addFloorEntity(floorEntity);
        } catch (Exception e) {
            exception = e;
        }

        assertEquals("FloorEntity cannot have explicit floorId: " + 1L, exception.getMessage());
    }

    @Test
    public void givenFloorWithNullName_whenAddFloor_thenThrowException(){
        FloorEntity floorEntity = new FloorEntity(null, 56.7, 35.2, 270.0, 3);
        Exception exception = null;

        try {
            floorService.addFloorEntity(floorEntity);
        } catch (Exception e) {
            exception = e;
        }
        
        assertEquals("FloorEntity field name is null", exception.getMessage());
    }

    @Test
    public void givenFloorWithNullGeoLength_whenAddFloor_thenThrowException(){
        FloorEntity floorEntity = new FloorEntity("HM3", null, 35.2, 270.0, 3);
        Exception exception = null;

        try {
            floorService.addFloorEntity(floorEntity);
        } catch (Exception e) {
            exception = e;
        }

        assertEquals("FloorEntity field geoLength is null", exception.getMessage());
    }

    @Test
    public void givenFloorWithNullGeoWidth_whenAddFloor_thenThrowException(){
        FloorEntity floorEntity = new FloorEntity("HM3", 56.7, null, 270.0, 3);
        Exception exception = null;

        try {
            floorService.addFloorEntity(floorEntity);
        } catch (Exception e) {
            exception = e;
        }

        assertEquals("FloorEntity field geoWidth is null", exception.getMessage());
    }

    @Test
    public void givenFloorWithNullAzimuth_whenAddFloor_thenThrowException(){
        FloorEntity floorEntity = new FloorEntity("HM3", 56.7, 35.2, null, 3);
        Exception exception = null;

        try {
            floorService.addFloorEntity(floorEntity);
        } catch (Exception e) {
            exception = e;
        }

        assertEquals("FloorEntity field azimuth is null", exception.getMessage());
    }

    @Test
    public void givenFloorWithNullLevel_whenAddFloor_thenThrowException(){
        FloorEntity floorEntity = new FloorEntity("HM3", 56.7, 35.2, 270.0, null);
        Exception exception = null;

        try {
            floorService.addFloorEntity(floorEntity);
        } catch (Exception e) {
            exception = e;
        }

        assertEquals("FloorEntity field level is null", exception.getMessage());
    }

    @Test
    public void givenFloorWithSameLevelInRepository_whenAddFloor_thenThrowException(){
        FloorEntity floorEntity = new FloorEntity("HM3", 56.7, 35.2, 270.0, 2);
        Exception exception = null;

        try {
            floorService.addFloorEntity(floorEntity);
        } catch (Exception e) {
            exception = e;
        }

        assertEquals("FloorEntity with level 2 already exist", exception.getMessage());
    }

    @Test
    public void givenValidFloor_whenAddFloor_thenReturnFloorWithId(){
        FloorEntity floorEntity = new FloorEntity("HM3", 56.7, 35.2, 270.0, 3);
        FloorEntity returnedFloor = null;

        try {
            returnedFloor = floorService.addFloorEntity(floorEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertTrue(returnedFloor.equals(new FloorEntity(10L, "HM3", 56.7, 35.2, 270.0, 3)));
    }


}
