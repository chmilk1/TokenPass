import static org.junit.Assert.*;

import org.junit.Test;

public class UseTP {

	@Test
	public void Play() {
		TokenPass PokenTass64 = new TokenPass(4);
		System.out.println(PokenTass64.getState());
		int rounds = 8;
		for (int i = 0; i < rounds; i++) {
			PokenTass64.distributeCurrentPlayerTokens();
			System.out.println(PokenTass64.getState());
		}
		System.out.println("------------------------------------======{FINAL TEST}======------------------------------------");
		PokenTass64.distributeCurrentPlayerTokens();
		System.out.println(PokenTass64.getState());
		assertTrue(true);
	}

}
