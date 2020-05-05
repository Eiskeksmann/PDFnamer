import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

public class Pdfnamer {

    private Gui gui;
    private Cell number_cell;
    private Cell name_cell;
    private Row number_row;
    private Row name_row;
    private ArrayList<NameSheme>  listofnames;
    private File path;
    private File[] scans_right;
    private File[] scans_wrong;
    private File pivot_right;
    private File pivot_wrong;

    public Pdfnamer(){

        gui = new Gui("PDFnamer",new Dimension(1000,400));
        path = new File("res");
        scans_wrong = path.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("SCAN") && name.endsWith("PDF");
            }
        });
        if(scans_wrong != null) pivot_wrong = scans_wrong[0];
        scans_right = path.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("ER") && name.endsWith("PDF");
            }
        });
        if(scans_right != null) pivot_right = scans_right[scans_right.length - 1];
        listofnames = new ArrayList<NameSheme>();

        for(File f : scans_wrong){
            System.out.println("WRONG: " +  f.getName());
        }
        for(File f : scans_right){
            System.out.println("RIGHT: " +  f.getName());
        }
        System.out.println("PIVOT WRONG: " + pivot_wrong.getName());
        System.out.println("PIVOT RIGHT: " + pivot_right.getName());
        if(scans_wrong.length == 0){ System.out.println("No Wrong Files found"); }
        if(scans_right.length == 0){ System.out.println("No Right Files found"); }
    }

    public void startRenamingProcess(){

        for(File f : scans_wrong){
                //boolean successor = f.renameTo("");
        }
    }
    public void preprocessRenaming(){

        //1-> TAKE PDF_PIVOT_RIGHT "ER2019-08-0122-2.PDF"
        //2-> EXTRACT STRINGTOKEN X-X-TOK-X.PDF
        //3-> TOK = 0122
        //4-> TAKE EXCEL_PIVOT_H "ER2019-01-4000-1.PDF"
    }

    public void addSheme(NameSheme ns){

        listofnames.add(ns);
    }

    public static void main(String args[]) throws IOException {

        Pdfnamer main = new Pdfnamer();
        //C:/Users/Administrator/Desktop/TODO/TODO/test.xlsx
        File myFile = new File("C://Users/Administrator/Desktop/TODO/TODO/offlinetest.xlsx");
        FileInputStream fis = new FileInputStream(myFile);

        // Finds the workbook instance for XLSX file
        XSSFWorkbook xssfwb = new XSSFWorkbook (fis);
        //FormulaEvaluator mainevaluator = xssfwb.getCreationHelper().createFormulaEvaluator();
        //mainevaluator.setIgnoreMissingWorkbooks(true);

        //A -> A1_KK
        //Map<String, FormulaEvaluator> bookmap = new HashMap<String, FormulaEvaluator>();
        //bookmap.put("test.xlsx", mainevaluator);
        //bookmap.put("A1_KK.xls", WorkbookFactory.create("A1_KK.xls").getCreationHelper().createFormulaEvaluator());

        //mainevaluator.setupReferencedWorkbooks(bookmap);

        // Return thrid sheet from the XLSX workbook
        XSSFSheet sheet = xssfwb.getSheetAt(0);

        boolean condition = false;
        Cell numbercell = null;
        Cell namecell = null;
        Row numberrow = null;
        Row namerow = null;
        CellReference numberref = null;
        CellReference nameref = null;

        for(int i = 2; !condition; i++) {

            numberref = new CellReference("A" + i);
            nameref = new CellReference("H" + i);

            if(sheet.getRow(numberref.getRow())!= null &&
                    sheet.getRow(nameref.getRow()) != null){

                numberrow = sheet.getRow(numberref.getRow());
                namerow = sheet.getRow(nameref.getRow());
                if(numberrow.getCell(numberref.getCol()) != null &&
                namerow.getCell(numberref.getCol()) != null) {
                    numbercell = numberrow.getCell(numberref.getCol());
                    namecell = namerow.getCell(nameref.getCol());
                } else {
                    condition = true;
                    System.out.println(i - 2 + "| Elements found");
                    break;
                }
            } else {
                condition = true;
                System.out.println(i - 2 + "| Elements found");
                break;
            }

            //CellValue val = mainevaluator.evaluate(cell);
            //System.out.println("Trying to evaluate: " + cell.getStringCellValue());
            switch (numbercell.getCellType()) {
                case BOOLEAN:
                    System.out.println(numbercell.getBooleanCellValue());
                    break;
                case NUMERIC:
                    System.out.println((int)numbercell.getNumericCellValue() + "| (NUMERIC)");
                    if (Double.toString(numbercell.getNumericCellValue()).equals("")) {
                        condition = true;
                        System.out.println(i - 2 + "| Elements found");
                        break;
                    }
                    break;
                case STRING:
                    System.out.println(numbercell.getStringCellValue()+ "| (STRING)");
                    if (numbercell.getStringCellValue().equals("")) {
                        condition = true;
                        System.out.println(i - 2 + "| Elements found");
                        break;
                    }
                    break;
                case BLANK:
                    break;
                case ERROR:
                    break;
            }
            switch (namecell.getCellType()) {
                case BOOLEAN:
                    System.out.println(namecell.getBooleanCellValue());
                    break;
                case NUMERIC:
                    System.out.println((int)namecell.getNumericCellValue() + "| (NUMERIC)");
                    if (Double.toString(namecell.getNumericCellValue()).equals("")) {
                        condition = true;
                        System.out.println(i - 2 + "| Elements found");
                        break;
                    }
                    break;
                case STRING:
                    System.out.println(namecell.getStringCellValue()+ "| (STRING)");
                    if (namecell.getStringCellValue().equals("")) {
                        condition = true;
                        System.out.println(i - 2 + "| Elements found");
                        break;
                    }
                    break;
                case BLANK:
                    break;
                case ERROR:
                    break;
            }
        }
    }
}
