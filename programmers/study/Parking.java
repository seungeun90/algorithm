package programmers.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Parking {

	public static void main(String[] args) {
		//int[] fees = {180, 5000, 10, 600};
		//String records[] = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		//String records[] = {"05:34 5961 IN", "06:34 5961 OUT", "07:34 5961 IN", "08:34 5961 OUT", "09:34 5961 IN", "10:34 5961 OUT", "11:34 5961 IN", "12:34 5961 OUT"};

		int[] fees = {1, 10, 1, 11};
		String records[] = {"00:00 1234 IN", "00:02 1234 OUT"};
		for (int x : solution(fees,records)) {
			System.out.println(x);	
		}
	}
	
	public static int[] solution(int[] fees, String[] records) {
        Map<String, Car> record = new HashMap();
        Map<String, Car> result = new HashMap();
       
        for (int i = 0; i < records.length; i++) {
        	  String[] arr = records[i].split(" ");
        	
        	  String time = arr[0];
        	  String carNum = arr[1];
        	  String inOrOut = arr[2];
        	 
        	  if("IN".equals(inOrOut)) { 
        		  record.put(carNum, new Car(carNum, new Time( time)));  
        	  } else { 
        		  //출차 시 총 주차 시간 계산
        		  /** 이전 기록에 동일 차량 존재 시 기록 덮어쓰지 않도록 주의 */
        		  int parkingMins = getParkingTime(record.get(carNum),new Time( time));
        		 
        		  result.put(carNum, 
        				  result.getOrDefault(carNum, new Car(carNum, new Time(time) ) )
        				  		.putPakingMins(parkingMins));
        		  record.remove(carNum);
        	  }
        	  
		}
        
        //출차되지 않은 차량 시간 계산 
        /** 이전 기록에 동일 차량 존재 시 기록 덮어쓰지 않도록 주의 */
        if(record.size() > 0) {
        	for (String carNum : record.keySet()) {
			  int parkingMins = getParkingTime(record.get(carNum),new Time("23:59"));
			  
			  Car car = result.getOrDefault(carNum, new Car(carNum, record.get(carNum).getTime()))
					  			.putPakingMins(parkingMins);
			  
			  result.put(carNum, car);
			  /** keyset 사용중 삭제로 동시성 문제 발생 코드 1번, 3~12번 통과 못함 */
       		 // record.remove(carNum); 
			}
        }
        

        //주차비 계산 
        List<Car> list = new ArrayList<Car>();
        for(String key : result.keySet()) {
        	Car car = result.get(key);
        	car.putCharge(calculate(car.getPakingMins(), fees));
        	list.add(car);
        }
        
        Collections.sort(list);
        
        return list.stream().mapToInt(Car::getCharge).toArray();
    }
	
	public static int getParkingTime(Car car, Time outTime) {
		return car.getParkingMins(outTime); 
	}
	
	public static int calculate(int time, int[] fees) {
		Caculator calculator = new Caculator(fees[0], fees[1], fees[2], fees[3]);
		return calculator.getCharge(time);
	}

}
class Car implements Comparable<Car>{
	String carNum;
	Time inTime;
	int charge;
	int pakingMins;
	public Car(String carNum, Time inTime) {
		this.carNum = carNum;
		this.inTime = inTime;
		this.charge = 0;
		this.pakingMins = 0;
	}
	public int getParkingMins(Time time){
		return this.inTime.getMinsOfTimeDiff(time);
	}
	public String getCarNum() {
		return carNum;
	}
	public Time getTime() {
		return inTime;
	}
	public Car putCharge(int charge) {
		this.charge += charge;
		return this;
	}
	public Car putPakingMins(int parkingMins) {
		this.pakingMins += parkingMins;
		return this;
	}
	public int getPakingMins() {
		return pakingMins;
	}
	public int getCharge() {
		return charge;
	}
	@Override
	public boolean equals(Object obj) {
		Car car = (Car) obj;
		return this.getCarNum().equals(car.getCarNum());
	}
	
	@Override
	public int compareTo(Car o) {
		return this.getCarNum().compareTo(o.getCarNum());
	}
	
}
class Time{
	String time;
	public Time(String time) {
		this.time = time;
	}
	public int getMinsOfTimeDiff(Time time) {
		return getHourDiff(time) * 60 + getMinsDiff(time);
	}
	private int getHourDiff(Time time) {
		return parserHour(time.time) - parserHour(this.time);
	}
	private int getMinsDiff(Time time) {
		return parserMins(time.time) - parserMins(this.time);
	}
	private int parserHour(String time){
		return Integer.parseInt(time.split(":")[0]);
	}
	private int parserMins(String time){
		return Integer.parseInt(time.split(":")[1]);
	}
	public String getTime() {
		return time;
	}
}
class Caculator{
	
	int basicHour ;
	int basicFee ;
	double additionalHour;
	int additionalFee ;
	
	public Caculator(int basicHour,int basicFee,double additionalHour,int additionalFee) {
		this.basicFee = basicFee;
		this.basicHour = basicHour;
		this.additionalHour = additionalHour;
		this.additionalFee = additionalFee;
	}
	
	public int getCharge(int parkingTime) {
		if(parkingTime <= basicHour) return basicFee;
		
		int chargableHours =(int) Math.ceil((parkingTime-basicHour)/additionalHour);
		return basicFee + (chargableHours * additionalFee);
	}
}
