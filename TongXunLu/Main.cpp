#include "MenuFunc.cpp"


//�˵�
void Menu(ElemList & L)
{
	LoadElemList(L);
	while (1)
	{
		system("CLS");
		cout<<"\t\t--------�˵�--------"<<endl;
		cout<<"\t\t1.�����µ�ͨѶ¼"<<endl;
		cout<<"\t\t2.������ϵ��"<<endl;
		cout<<"\t\t3.������ϵ��"<<endl;
		cout<<"\t\t4.�޸���ϵ��"<<endl;
		cout<<"\t\t5.ɾ����ϵ��"<<endl;
		cout<<"\t\t6.��ʾ��ϵ��"<<endl;
		cout<<"\t\t7.��ϵ������"<<endl;
		cout<<"\t\t8.�˳�"<<endl;
		cout<<"\t\t--------------------"<<endl;
		cout<<"��ѡ��:";
		int op;
		cin>> op;
		switch(op)
		{
		case 1:MenuCreatList(L);break;
		case 2:MenuAddElem(L);break;
		case 3:MenuFindElem(L);break;
		case 4:MenuAlterElem(L);break;
		case 5:MenuDleteElem(L);break;
		case 6:MenuDisplayElem(L);break;
		case 7:MenuSortElemList(L);break;
		case 8:DeleteElemList(L);return;
		default:cout<<"�������,����������!"<<endl;
			getchar();getchar();
		}
	}
	return;
}

void Quit(ElemList & L)//�˳�
{
	cout<<"ȷ���˳�?(y/n)";
	char op;
	cin>>op;
	if (op=='y'||op=='Y')
	{
		exit(0);
	}
	return ;
}

int main()
{
	ElemList L;
	while (1)
	{
		system("CLS");
		cout<<"\t\t--------ͨѶ¼--------"<<endl;
		cout<<"\t\t1.�˵�"<<endl;
		cout<<"\t\t2.�˳�"<<endl;
		cout<<"\t\t----------------------"<<endl;
		cout<<"��ѡ��:";
		int op;
		cin>> op;
		switch(op)
		{
		case 1:
			Menu(L);break;
		case 2:
			Quit(L);break;
		default:cout<<"�������,����������!"<<endl;
			getchar();getchar();
		}
	}
	return 0;
}