package Environment;

public class Environment {
	//������ ��ġ
	int PRICE_IDX = 4;
	//�ֽ� ������ ��Ʈ ������
	int[][] chart_data;
	//���� ����ġ
	int[] observation;
	//��Ʈ �����Ϳ����� ���� ��ġ
	int idx;
	
	//������
	public Environment(int[][] chart_data) {
		this.chart_data = chart_data;
		this.observation = null;
		this.idx = -1;
		
	}
	
	//idx�� observation�� �ʱ�ȭ
	public void reset() {
		this.observation = null;
		this.idx = -1;
	}
	
	//idx�� ���� ��ġ�� �̵��ϰ� observation�� ������Ʈ
	public int[] observe() {
		//�Ϸ羿 �̵��ϸ� ���� ������ ����
		if(chart_data.length > idx+1) {
			//��Ʈ �������� ��ü ���̺��� ���� ��ġ�� ���� ���
			idx += 1;
			//idx���� �����͸� ������
			observation = chart_data[idx];
			return observation;
		}
		//������ �����Ͱ� ���� ���
		return null;
	}
	
	//���� observation���� ������ ȹ��. ���� close�� ��ġ�� 5��° ���̱� ������ PRICE_IDX���� 4�̴�
	public int get_price() {
		if(observation!=null) {
			//������
			return observation[PRICE_IDX];
		}
		return -1;
	}
}
