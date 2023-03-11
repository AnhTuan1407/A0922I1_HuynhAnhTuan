package on_tap_module2.until;

import on_tap_module2.model.ATM;
import on_tap_module2.model.Credit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteCredit {
    public List<Credit> readCredit(String path) {
        List<Credit> creditList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().equals("")) {
                    continue;
                }
                String[] result = line.split(",");
                if (result.length == 6)
                {
                    String numCard = result[0];
                    String nameCard = result[1];
                    String identityCard = result[2];
                    String address = result[3];
                    double balance = Double.parseDouble(result[4]);
                    double limit = Double.parseDouble(result[5]);
                    Credit credit = new Credit(numCard, nameCard, identityCard, address, balance, limit);
                    creditList.add(credit);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return creditList;
    }

    public void writeCredit(List<Credit> creditList, String path,Boolean a) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, a))) {
            String str = "";
            for (Credit credit : creditList) {
                str += credit.getNumCard() + "," + credit.getNameCard() + "," + credit.getIdentityCard() + "," + credit.getAddress() + "," + credit.getBalance() + "," + credit.getLimit() + "\n";
            }
            bufferedWriter.write(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
