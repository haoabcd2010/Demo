#include "NodeFunc.cpp"
#include "SaveLoadList.cpp"

/*
1:MenuCreatList(L);
2:MenuAddElem(L);
3:MenuFindElem(L);
4:MenuAlterElem(L);
5:MenuDleteElem(L);
6:MenuDisplayElem(L);

1.�����µ�ͨѶ¼
2.������ϵ��

3.������ϵ��(��ϸ)
3.������ϵ��(����)

4.�޸���ϵ��(���Ҳ���)
4.�޸���ϵ��(�޸Ĳ���)
4.�޸���ϵ��(���沿��)

5.ɾ����ϵ��(���Ҳ���)
5.ɾ����ϵ��(���沿��)

6.��ʾ��ϵ��
*/

void MenuAddElem(ElemList & L);

int Y_N()
{
	char c;
	cin>>c;
	if (c=='Y'||c=='y')
		return OK;
	return NO;
}

//1.�����µ�ͨѶ¼
void MenuCreatList(ElemList & L)
{
	if (L.head!=NULL)
	{
		cout<<"����ͨѶ¼��ȷ��Ҫ���´���?(y/n)";
		if (Y_N()==0)
			return;
	}
	CreatElemList(L);
	cout<<"�Ƿ���Ҫ���Ԫ��?(y/n)";
	if (Y_N())
	{
		cout<<"��������ӵĸ���:";
		int n;
		cin>>n;
		for (int i=1;i<=n;i++)
		{
			cout<<"��ϵ��"<<i<<":"<<endl;
			MenuAddElem(L);
		}
	}
	cout<<"�����ɹ�!"<<endl;
	SaveElemList(L);
	getchar();
}

//2.������ϵ��
void MenuAddElem(ElemList & L)
{
	Elem t;
	cout<<"����:";	cin>>t.name;
	t.word=Get_Head_Word(t.name);
	int n;
	cout<<"�ֻ��Ÿ���Ϊ:(0/1/2)";cin>>n;
	if (n==0) 
	{
		strcpy(t.phone1,"��");
		strcpy(t.phone2,"��");
	}
	for (int i=1;i<=n;i++)
	{
		if (i==1)
		{
			cout<<"�ֻ���"<<i<<":";
			cin>>t.phone1;
			strcpy(t.phone2,"��");
		}
		if (i==2)
		{
			cout<<"�ֻ���"<<i<<":";
			cin>>t.phone2;
		}
		if (i>=3)
		{
			cout<<"������ 2 ���ֻ���."<<endl;
			break;
		}
	}
	cout<<"�Ƿ���дQQ:(y/n)";
	strcpy(t.qq,"��");
	if (Y_N())
	{
		cout<<"QQ:";
		cin>>t.qq;
	}
	cout<<"ȷ�����?(y/n)";
	if (Y_N())
	{
		AddElem(L,&t);
		cout<<"��ӳɹ�!"<<endl;
		getchar();getchar();
	}
	SaveElemList(L);
}

//3.������ϵ��(��ϸ)
void MenuFind_KindElem(ElemList & L,int op)
{
	cout<<"������Ҫ���ҵ���ϵ�˵�";
	switch(op)
	{
	case 1:cout<<"����:";break;
	case 2:cout<<"�ֻ���:";break;
	case 3:cout<<"QQ��:";break;
	}
	char go[20];
	cin>>go;
	if (op==3) op=4;//3 ���˳������������
	Elem * pos = FindElem(L,go,op);
	if (pos==NULL)
	{
		cout<<"�޴���ϵ��!"<<endl;
	}
	else
	{
		cout<<"-------------------------------------------------------------"<<endl;
		printf("%-12s %-16s %-16s %-16s\n","����","�ֻ���1","�ֻ���2","QQ");
		cout<<"-------------------------------------------------------------"<<endl;
		printf("%-12s %-16s %-16s %-16s\n",pos->name,pos->phone1,pos->phone2,pos->qq);
		cout<<"-------------------------------------------------------------"<<endl;
	}
}

//3.������ϵ��(����)
void MenuFindElem(ElemList & L)
{
	system("CLS");

	cout<<"\t\t--------����--------"<<endl;
	cout<<"\t\t��������ҵķ�ʽ:"<<endl;
	cout<<"\t\t1.����"<<endl;
	cout<<"\t\t2.�ֻ���"<<endl;
	cout<<"\t\t3.QQ"<<endl;
	cout<<"\t\t4.�˳�"<<endl;
	cout<<"\t\t--------------------"<<endl;
	cout<<"��ѡ��:";
	int op; 
	cin>>op;
	if (op==4) return ;
	if (op>=1&&op<=3)
		MenuFind_KindElem(L,op);
	else
		cout<<"�������!"<<endl;
	getchar();getchar();
}

//4.�޸���ϵ��(���Ҳ���)
Elem * MenuAlter_FindElem(ElemList & L)
{
	system("CLS");
	cout<<"\t\t--------����--------"<<endl;
	cout<<"\t\t�����������ķ�ʽ:"<<endl;
	cout<<"\t\t1.����������"<<endl;
	cout<<"\t\t2.���ֻ�������"<<endl;
	cout<<"\t\t3.��QQ����"<<endl;
	cout<<"\t\t--------------------"<<endl;
	cout<<"��ѡ��:";
	int op;
	cin>>op;
	while (1)
	{
		if (op>=1&&op<=3)
		{
			cout<<"������Ҫ���ҵ���ϵ�˵�";
			switch(op)
			{
			case 1:cout<<"����:";break;
			case 2:cout<<"�ֻ���:";break;
			case 3:cout<<"QQ��:";break;
			}
			char go[20];
			cin>>go;
			if (op==3) op=4;//3 ���˳������������
			return FindElem(L,go,op);
		}
		else
			cout<<"�������!"<<endl;
	}
	return NULL;
}

//4.�޸���ϵ��(�޸Ĳ���)
int MenuXiuGaiElem(Elem * pos)
{
	system("CLS");
	cout<<"------------------�޸Ĵ���ϵ��һ������------------------"<<endl;
	printf("%-12s %-16s %-16s %-16s\n","����","�ֻ���1","�ֻ���2","QQ");
	printf("%-12s %-16s %-16s %-16s\n",pos->name,pos->phone1,pos->phone2,pos->qq);
	cout<<"--------------------------------------------------------"<<endl;
	cout<<"��Ҫ�޸ĵ���:"<<endl;
	cout<<"1.����"<<endl;
	cout<<"2.�ֻ���1"<<endl;
	cout<<"3.�ֻ���2"<<endl;
	cout<<"4.QQ"<<endl;
	cout<<"--------------------------------------------------------"<<endl;
	cout<<"��ѡ��:";
	int op;
	cin>>op;
	cout<<"�޸�Ϊ:";
	char k[20];
	cin>>k;
	switch (op)
	{
	case 1:strcpy(pos->name,k);pos->word=Get_Head_Word(pos->name);break;
	case 2:strcpy(pos->phone1,k);break;
	case 3:strcpy(pos->phone2,k);break;
	case 4:strcpy(pos->qq,k);break;
	default:cout<<"�������!"<<endl;
	}
	return 1;
}

//4.�޸���ϵ��(���沿��)
void MenuAlterElem(ElemList & L)
{
	Elem * pos =  MenuAlter_FindElem(L);
	if (pos==NULL)
	{
		cout<<"����ϵ�˲�����!"<<endl;
	}
	else
	{
		while (1)
		{
			MenuXiuGaiElem(pos);
			cout<<"�����޸Ĵ���ϵ��?(y/n)";
			if (!Y_N())
				break;
		}
		cout<<"�޸����!"<<endl;
		SaveElemList(L);
	}
	getchar();getchar();
	return;
}

//5.ɾ����ϵ��(���Ҳ���)
Elem * MenuDelete_FindElem(ElemList & L)
{
	system("CLS");
	cout<<"\t\t--------����--------"<<endl;
	cout<<"\t\t�����������ķ�ʽ:"<<endl;
	cout<<"\t\t1.����������"<<endl;
	cout<<"\t\t2.���ֻ�������"<<endl;
	cout<<"\t\t3.��QQ����"<<endl;
	cout<<"\t\t--------------------"<<endl;
	cout<<"��ѡ��:";
	int op;
	cin>>op;
	while (1)
	{
		if (op>=1&&op<=3)
		{
			cout<<"������Ҫ���ҵ���ϵ�˵�";
			switch(op)
			{
			case 1:cout<<"����:";break;
			case 2:cout<<"�ֻ���:";break;
			case 3:cout<<"QQ��:";break;
			}
			char go[20];
			cin>>go;
			if (op==3) op=4;//3 ���˳������������
			return FindElem(L,go,op);
		}
		else
			cout<<"�������!"<<endl;
	}
	return NULL;
}

//5.ɾ����ϵ��(���沿��)
void MenuDleteElem(ElemList & L)
{
	Elem * pos = MenuDelete_FindElem(L);
	if (pos==NULL)
	{
		cout<<"δ�ҵ�����ϵ��!";
		getchar();getchar();
		return ;
	}
	cout<<"------------------����ϵ������--------------------------"<<endl;
	printf("%-12s %-16s %-16s %-16s\n","����","�ֻ���1","�ֻ���2","QQ");
	printf("%-12s %-16s %-16s %-16s\n",pos->name,pos->phone1,pos->phone2,pos->qq);
	cout<<"--------------------------------------------------------"<<endl;
	cout<<"ȷ��ɾ��?(y/n)";
	if (Y_N())
	{
		 DeleteElem(L,pos);
		 cout<<"ɾ���ɹ�!"<<endl;
		 SaveElemList(L);
		 getchar();getchar();
		 return;
	}
}

//6.��ʾ��ϵ��
void MenuDisplayElem(ElemList & L)
{
	system("CLS");
	if (!DisplayElemList(L))
		cout<<"��ϵ��Ϊ��!"<<endl;
	getchar();getchar();
}


//��ϵ������
void MenuSortElemList(ElemList &L)
{
	if (L.head==NULL)
	{
		cout<<"��ϵ��Ϊ��!"<<endl;
		getchar();getchar();
		return ;
	}
	SortElemList(L);
	cout<<"������˳��������:"<<endl;
	DisplayElemList(L);
	cout<<"�Ƿ񱣴�?(y/n)";
	if (Y_N())
	{
		SaveElemList(L);
		cout<<"����ɹ�!"<<endl;
		getchar();getchar();
		return ;
	}
	LoadElemList(L);
}