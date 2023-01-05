import entities.Contract;
import entities.Installment;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import services.ContractService;

public class App {

  public static void main(String[] args) throws Exception {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    System.out.println("======================================");
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    System.out.println("Entre com os dados do comtrato!");
    System.out.print("Numero: ");
    Integer number = sc.nextInt();
    System.out.print("Data (dd/MM/yyyy): ");
    LocalDate date = LocalDate.parse(sc.next(), fmt);
    System.out.print("Valor do Contrato: ");
    Double totalValue = sc.nextDouble();

    Contract obj = new Contract(number, date, totalValue);

    System.out.print("Entre com o numero de parcelas: ");
    int n = sc.nextInt();

    ContractService contractService = new ContractService(null);

    contractService.processContract(obj, n);
    System.out.println("==============================================");
    System.out.println("Parcelas: ");
    for (Installment installment : obj.getInstallments()) {
      System.out.println(installment);
    }

    System.out.println("===================FIM===================");
    sc.close();
  }
}
