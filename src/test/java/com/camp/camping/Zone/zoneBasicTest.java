package com.camp.camping.Zone;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.camp.camping.DTO.ZoneDTO;
import com.camp.camping.service.ZoneService;

@SpringBootTest
class zoneBasicTest {

	ZoneDTO zone = null;
	List<ZoneDTO> zones = null;

	@Inject
	ZoneService service;

	/*
	 * @Test void insert() { zone = new ZoneDTO(0, 1, "배고파", "배고플때찾는 존"); try {
	 * service.insert(zone); System.out.println("성공"); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 * 
	 * @Test void select() { try { System.out.print(service.select(1)); } catch
	 * (Exception e) { e.printStackTrace(); } }
	 * 
	 * @Test void selectAll() { try { System.out.print(service.selectAll()); } catch
	 * (Exception e) { e.printStackTrace(); } }
	 * 
	 * @Test void update() { zone = new ZoneDTO(4, 1, "배고파 디지것다", "쿰쳑쿰쳑"); try {
	 * service.update(zone); System.out.println("성공"); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 * 
	 * @Test void delete() { try { service.delete(5); System.out.println("성공"); }
	 * catch (Exception e) { e.printStackTrace(); } }
	 */
	
	@Test
	void selectZone() {
		try {
			service.selectZone(1);
			System.out.print(service.selectZone(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
