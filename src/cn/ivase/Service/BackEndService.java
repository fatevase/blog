package cn.ivase.Service;

import java.util.List;
import java.util.Map;
/**
 * *��¼һ�� ���ݿ������ֻ������ȡ���ݿ�����
 * action��������ǰ�����ݽ��н����� ��ֱֹ�ӻ�ȡ���ݿ����� ���� �������ٶ����ݵ��޸� 
 * *ֻ���ڽ��շ���� ��ǰ�˷��������� �ͷ������ݵ�ǰ��
 * *��������ڴ�������ݿ�ȡ����ֵ�ͼӹ���Ҫ�������ݿ��ֵ
 * *
 * *��������������Ҫ�Ӹ����ݿ�ȡ���ݵĲ�����Ҫ����д��һ���������в���
 * *ֱ�ӵ���֮ǰд�ķ��� ���߽�����д�ڶ�Ӧ�����ݿ������
 * 
 * *��д����˲���ʶ��֮ǰǰ�����ݻ��Ե�һϵ������ ��¼һ�� 
 *@Title BackEndService.java
 *@description TODO
 *@time 2018��12��24�� ����12:25:12
 *@author FateVase
 *@version 1.0
 *
 */
public interface BackEndService {
	public Map<String,Object> ShowBackendIndex();
	public List<Map<String, Object>> ShowEssayIndex();
	public List<Map<String, Object>> ShowCommentsIndex();
}
