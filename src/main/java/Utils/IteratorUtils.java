package Utils;

import config.Config;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by chongqing on 2017/4/13.
 * 参数化excel
 */
public class IteratorUtils implements Iterator<Object[]> {
    private static Logger logger=Logger.getLogger(IteratorUtils.class);

    private int rowNum;//有效行
    private int colNum;//有效列
    private int curRowNum;//当前行
    private String columnName[];//表头数组

    Workbook workbook;//声明工作空间
    Sheet sheet;//声明表
    //private String filePath  = "src/image";
    public IteratorUtils(String fileName , String sheetName,String... suffix) throws IOException {
        //参数文件路径/文件名，表名，后缀名（.xls/.xlsx）
        readExcel(fileName,sheetName,suffix);
    }
    //参数文件路径/文件名，表名，后缀名（.xls/.xlsx）
    public void readExcel(String fileName, String sheetName,String... suffix) throws IOException {
        //文件流
        String fileName1=null;
        if(suffix.length!=0)
        {
            if(suffix[0]==".xlsx"){
                fileName1 =fileName+".xlsx";
                FileInputStream fileInputStream = new FileInputStream(fileName1);
                workbook = new XSSFWorkbook(fileInputStream);
            }else if(suffix[0]==".xls"){
                fileName1 =fileName+".xls";
                FileInputStream fileInputStream = new FileInputStream(fileName1);
                workbook = new HSSFWorkbook(fileInputStream);
            }else {
                logger.error("后缀名错误，不是excel文件");
            }
        }
        //获取表
        sheet = workbook.getSheet(sheetName);
        //获取表头行
        Row row = sheet.getRow(0);
        //获取有效行和有效列
        rowNum = sheet.getPhysicalNumberOfRows();
        colNum = row.getPhysicalNumberOfCells();
        //声明一个数组，长度为有效列
        columnName = new String[colNum];
        int count = 0;
        //首行标题头转化为迭代器
        Iterator<Cell> heads = row.cellIterator();
        while (heads.hasNext()){
            Cell cell = heads.next();
            //设置单元格的格式为S
            cell.setCellType(Cell.CELL_TYPE_STRING);
            //把值放入数组
            columnName[count] = cell.getStringCellValue();
            //System.out.println(columnName[count]);
            count++;
        }
        //当前行下移
        this.curRowNum++;
    }

    public boolean hasNext() {
        //有效行为0或当前行大于有效行，迭代器就不再继续往下取值
        if (rowNum == 0 || this.curRowNum >= rowNum){
            return false;
        }else {
            return true;
        }
    }

    public Object[] next() {
        //
        Map<String,String> map = new HashMap<String,String>();
        String value ;
        //获取当前行
        Row row = sheet.getRow(curRowNum);
        //循环取值放入map
        for (int i = 0;i<colNum;i++){
            row.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
            value = row.getCell(i).getStringCellValue();
            //表头与数据一一对应
            map.put(columnName[i],value);
        }
        this.curRowNum++;
        //声明一个Object数组，长度为1
        Object object[] = new Object[1];
        object[0] = map;
        return object;
    }

    public void remove() {
    }
//    @DataProvider(name = "data1")
//    public Iterator<Object[]> token() throws IOException {
//        return new IteratorUtils("D:\\sunny\\软件\\get_token","get_token",".xlsx");
//    }
//    @Test(dataProvider = "data1")
//    public void test(Map<String,String> map){
//        Map<String,String> map1=new HashMap<String, String>();
//        map1.put("grant_type",map.get("参数grant_type"));
//        map1.put("appid",map.get("参数appid"));
//        map1.put("secret",map.get("参数secret"));
//        String response=RequestUtils.get(map.get("接口地址"),map1);
//        String access_token=DataUtils.JsonParse(response,"$.access_token");
//        if (response.length()!=0){
//            if(response.contains(map.get("断言"))){
//                Assertion assertion=new Assertion();
//                assertion.assertEquals(map.get("实际结果"),map.get("预期结果"));
//                System.out.println("测试通过");
//            }else {
//                System.out.println("测试不通过");
//            }
//        }else {
//            System.out.println("appid错误");
//        }
//        System.out.println(access_token);
//
//    }
    public static void main(String[] args) throws IOException {
//        IteratorUtils readexcel=new IteratorUtils("D:\\sunny\\软件\\get_token","get_token",".xlsx");
//        readexcel.readExcel("D:\\sunny\\软件\\get_token","get_token",".xlsx");
        System.out.println(Config.request_type);
        switch(1){
            case 1:

                break;
        }

    }


}
