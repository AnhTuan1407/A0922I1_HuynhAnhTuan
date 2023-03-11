package on_tap_module2.until;

import on_tap_module2.model.ATM;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteATM {
    public List<ATM> readATM(String path) {
        List<ATM> atmList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().equals("")) {
                    continue;
                }
                String[] result = line.split(",");
                if (result.length == 5)
                {
                    String numCard = result[0];
                    String nameCard = result[1];
                    String identityCard = result[2];
                    String address = result[3];
                    double surplus = Double.parseDouble(result[4]);
                    ATM atm = new ATM(numCard, nameCard, identityCard, address, surplus);
                    atmList.add(atm);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return atmList;
    }

    public void writeATM(List<ATM> atmList, String path,Boolean a) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, a))) {
            String str = "";
            for (ATM atm : atmList) {
                str += atm.getNumCard() + "," + atm.getNameCard() + "," + atm.getIdentityCard() + "," + atm.getAddress() + "," + atm.getSurplus() + "\n";
            }
            bufferedWriter.write(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
