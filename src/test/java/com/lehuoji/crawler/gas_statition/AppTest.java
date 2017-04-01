package com.lehuoji.crawler.gas_statition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.lehuoji.crawler.gas_statition.domain.GasStation;

/**
 * 
 * @author 王辉阳
 * @Description 1，读取json文件，得到加油站对象数据集 2，转excel输出
 */
public class AppTest {
	/***
	 * 获取指定目录下的所有的文件（不包括文件夹），采用了递归
	 * 
	 * @param obj
	 *            File对象或者路径字符串
	 * @return
	 */
	public static ArrayList<File> getListFiles(Object obj) {
		File directory = null;
		if (obj instanceof File) {
			directory = (File) obj;
		} else {
			directory = new File(obj.toString());
		}
		ArrayList<File> files = new ArrayList<File>();
		if (directory.isFile()) {
			files.add(directory);
			return files;
		} else if (directory.isDirectory()) {
			File[] fileArr = directory.listFiles();
			for (int i = 0; i < fileArr.length; i++) {
				File fileOne = fileArr[i];
				files.addAll(getListFiles(fileOne));
			}
		}
		return files;
	}

	/**
	 * 文件对象转为相对路径（Path）的字符串表示
	 * 
	 * @param files
	 * @return
	 */
	private List<String> files2Paths(ArrayList<File> files) {
		List<String> paths = new ArrayList<>();
		for (File file : files) {
			paths.add(file.getPath());
		}
		return paths;
	}

	/**
	 * 深圳加油站读取json数据转化为excel
	 */
	@Test
	public void readShenZhen() {
		try {
			List<GasStation> shenzhenGasStations = readDatas(files2Paths(getListFiles("datas/深圳/")));
			List<GasStation> guangzhouGasStations = readDatas(files2Paths(getListFiles("datas/广州/")));
			List<GasStation> foshanGasStations = readDatas(files2Paths(getListFiles("datas/佛山/")));
			List<GasStation> dongguanGasStations = readDatas(files2Paths(getListFiles("datas/东莞/")));
			List<GasStation> zhuhaiGasStations = readDatas(files2Paths(getListFiles("datas/珠海/")));
			List<GasStation> shantouGasStations = readDatas(files2Paths(getListFiles("datas/汕头/")));
			List<GasStation> qingyuanGasStations = readDatas(files2Paths(getListFiles("datas/清远/")));

			List<GasStation> beijngGasStations = readDatas(files2Paths(getListFiles("datas/北京/")));
			List<GasStation> shanghaiGasStations = readDatas(files2Paths(getListFiles("datas/上海/")));
			List<GasStation> tianjinGasStations = readDatas(files2Paths(getListFiles("datas/天津/")));
			List<GasStation> shenyangGasStations = readDatas(files2Paths(getListFiles("datas/沈阳/")));
			List<GasStation> dalianGasStations = readDatas(files2Paths(getListFiles("datas/大连/")));
			List<GasStation> qingdaoGasStations = readDatas(files2Paths(getListFiles("datas/青岛/")));
			List<GasStation> jinanGasStations = readDatas(files2Paths(getListFiles("datas/济南/")));
			List<GasStation> xianGasStations = readDatas(files2Paths(getListFiles("datas/西安/")));
			List<GasStation> nanjingGasStations = readDatas(files2Paths(getListFiles("datas/南京/")));
			List<GasStation> hangzhouGasStations = readDatas(files2Paths(getListFiles("datas/杭州/")));
			List<GasStation> wuxiGasStations = readDatas(files2Paths(getListFiles("datas/无锡/")));
			List<GasStation> xiamenGasStations = readDatas(files2Paths(getListFiles("datas/厦门/")));
			List<GasStation> fuzhouGasStations = readDatas(files2Paths(getListFiles("datas/福州/")));
			List<GasStation> chongqingGasStations = readDatas(files2Paths(getListFiles("datas/重庆/")));
			List<GasStation> chengduGasStations = readDatas(files2Paths(getListFiles("datas/成都/")));
			List<GasStation> wuhanGasStations = readDatas(files2Paths(getListFiles("datas/武汉/")));
			List<GasStation> changshaGasStations = readDatas(files2Paths(getListFiles("datas/长沙/")));
			// 导出excel
			// 创建HSSFWorkbook对象(excel的文档对象)
			HSSFWorkbook wb = new HSSFWorkbook();

			exportOneSheet(shenzhenGasStations, wb, "深圳加油站");
			exportOneSheet(guangzhouGasStations, wb, "广州加油站");
			exportOneSheet(foshanGasStations, wb, "佛山加油站");
			exportOneSheet(dongguanGasStations, wb, "东莞加油站");
			exportOneSheet(zhuhaiGasStations, wb, "珠海加油站");
			exportOneSheet(shantouGasStations, wb, "汕头加油站");
			exportOneSheet(qingyuanGasStations, wb, "清远加油站");

			exportOneSheet(beijngGasStations, wb, "北京加油站");
			exportOneSheet(shanghaiGasStations, wb, "上海加油站");
			exportOneSheet(tianjinGasStations, wb, "天津加油站");
			exportOneSheet(shenyangGasStations, wb, "沈阳加油站");
			exportOneSheet(dalianGasStations, wb, "大连加油站");
			exportOneSheet(qingdaoGasStations, wb, "青岛加油站");
			exportOneSheet(jinanGasStations, wb, "济南加油站");
			exportOneSheet(xianGasStations, wb, "西安加油站");
			exportOneSheet(nanjingGasStations, wb, "南京加油站");
			exportOneSheet(hangzhouGasStations, wb, "杭州加油站");
			exportOneSheet(wuxiGasStations, wb, "无锡加油站");
			exportOneSheet(xiamenGasStations, wb, "厦门加油站");
			exportOneSheet(fuzhouGasStations, wb, "福州加油站");
			exportOneSheet(chongqingGasStations, wb, "重庆加油站");
			exportOneSheet(chengduGasStations, wb, "成都加油站");
			exportOneSheet(wuhanGasStations, wb, "武汉加油站");
			exportOneSheet(changshaGasStations, wb, "长沙加油站");

			OutputStream output = new FileOutputStream("E:/加油站.xls");
			wb.write(output);
			output.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<GasStation> readDatas(String... filePath) {
		List<GasStation> gasStations = new ArrayList<>();
		try {
			for (String path : filePath) {
				gasStations.addAll(txt2List(path));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gasStations;
	}

	private List<GasStation> readDatas(List<String> filePath) {
		List<GasStation> gasStations = new ArrayList<>();
		try {
			for (String path : filePath) {
				gasStations.addAll(txt2List(path));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 排序：默认根据区域编码升序
		Collections.sort(gasStations, new Comparator<GasStation>() {
			@Override
			public int compare(GasStation o1, GasStation o2) {
				return (o1.getAdcode().compareTo(o2.getAdcode()));
			}
		});
		return gasStations;
	}

	/**
	 * json转为list数据集
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	private List<GasStation> txt2List(String path) throws IOException {
		List<String> lines = new ArrayList<>();
		lines.addAll(Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8));
		StringBuilder sb = new StringBuilder();
		for (String line : lines) {
			sb.append(line);
		}

		List<GasStation> gasStations = JSON.parseArray(sb.toString(), GasStation.class);

		return gasStations;
	}

	private void exportOneSheet(List<GasStation> gasStations, HSSFWorkbook wb, String sheetName) throws FileNotFoundException, IOException {
		// 导出excel
		// 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet(sheetName);
		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1 = sheet.createRow(0);
		// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell = row1.createCell(0);
		// 设置单元格内容
		cell.setCellValue("加油站一览表");
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 9));
		// 在sheet里创建第二行
		HSSFRow row2 = sheet.createRow(1);
		// 创建单元格并设置单元格内容
		row2.createCell(0).setCellValue("名称");
		row2.createCell(1).setCellValue("所在省份编码");
		row2.createCell(2).setCellValue("所在省份");
		row2.createCell(3).setCellValue("城市编码");
		row2.createCell(4).setCellValue("城市名");
		row2.createCell(5).setCellValue("区域编码");
		row2.createCell(6).setCellValue("区域名称");
		row2.createCell(7).setCellValue("地址");
		row2.createCell(8).setCellValue("电话");

		// 在sheet里创建第三行
		for (int i = 0; i < gasStations.size(); i++) {
			GasStation gasStation = gasStations.get(i);
			HSSFRow row3 = sheet.createRow(sheet.getLastRowNum() + 1);
			row3.createCell(0).setCellValue(gasStation.getName());
			row3.createCell(1).setCellValue(gasStation.getPcode());
			row3.createCell(2).setCellValue(gasStation.getPname());
			row3.createCell(3).setCellValue(gasStation.getCitycode());
			row3.createCell(4).setCellValue(gasStation.getCityname());
			row3.createCell(5).setCellValue(gasStation.getAdcode());
			row3.createCell(6).setCellValue(gasStation.getAdname());
			row3.createCell(7).setCellValue(gasStation.getAddress());
			if (null == gasStation.getTel() || gasStation.getTel().length() < 3) {
				row3.createCell(8).setCellValue("无地址信息");
			} else {
				row3.createCell(8).setCellValue(gasStation.getTel());
			}
		}

	}
}
