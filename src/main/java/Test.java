import beans.Machine;
import service.MachineService;

public class Test {

	public static void main(String[] args) {
		MachineService ms = new MachineService();
		for(Machine m : ms.findAll()) {
			System.out.println(m.getReference());
		}
	}
}
