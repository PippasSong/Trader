package Environment;

public class Environment {
	//종가의 위치
	int PRICE_IDX = 4;
	//주식 종목의 차트 데이터
	int[][] chart_data;
	//현재 관측치
	int[] observation;
	//차트 데이터에서의 현재 위치
	int idx;
	
	//생성자
	public Environment(int[][] chart_data) {
		this.chart_data = chart_data;
		this.observation = null;
		this.idx = -1;
		
	}
	
	//idx와 observation을 초기화
	public void reset() {
		this.observation = null;
		this.idx = -1;
	}
	
	//idx를 다음 위치로 이동하고 observation을 업데이트
	public int[] observe() {
		//하루씩 이동하며 관측 데이터 제공
		if(chart_data.length > idx+1) {
			//차트 데이터의 전체 길이보다 다음 위치가 작을 경우
			idx += 1;
			//idx행의 데이터를 가저옴
			observation = chart_data[idx];
			return observation;
		}
		//제공할 데이터가 없는 경우
		return null;
	}
	
	//현재 observation에서 종가를 획득. 종가 close의 위치가 5번째 열이기 때문에 PRICE_IDX값은 4이다
	public int get_price() {
		if(observation!=null) {
			//종가값
			return observation[PRICE_IDX];
		}
		return -1;
	}
}
