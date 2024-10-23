package no.hvl.Obligatorisk4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.hvl.Obligatorisk4.deltakerliste.Deltaker;
import no.hvl.Obligatorisk4.deltakerliste.DeltakerRepo;
import no.hvl.Obligatorisk4.deltakerliste.DeltakerService;

@ExtendWith(MockitoExtension.class)
public class LoadTest {
	
	@Mock
	private DeltakerRepo drepo; 
	
	@InjectMocks
	DeltakerService ds; 
	
	// Tester om man kan melde på en deltaker skikkelig
	@Test
	public void meldePaaDeltakerTest() {
		Deltaker d = new Deltaker("Lars", "Larsen", "45789123", "mann", "passord");
		when(drepo.existsByMobil("45789123")).thenReturn(true);
		drepo.save(d);
		assertNotNull(drepo.existsByMobil("45789123"));
	}
	
	@Test
	public void findByFornavnTest() {
		when(drepo.findByFornavn("Fredrik")).thenReturn(new Deltaker("Fredrik", "Enes", "46838625", "mann", "passord"));
		Deltaker d = ds.finnFornavn("Fredrik");
		assertEquals(d.getFornavn(), "Fredrik");
	}
	
	@Test
	public void meldeFeilPaaDeltakerTest() {
		Deltaker d = new Deltaker("A", "A", "333", "annet", "passord");
		drepo.save(d);
		assertFalse(drepo.existsByMobil("333"));
	}
	
	@Test
	public void findByMobilTest() {
		when(drepo.findByMobil("46838625")).thenReturn(new Deltaker("Fredrik", "Enes", "46838625", "mann", "passord"));
		Deltaker d = ds.finnMobil("46838625");
		assertEquals(d.getMobil(), "46838625");
	}
}
