#include "NodeFunc.cpp"
#include "SaveLoadList.cpp"

/*
1:MenuCreatList(L);
2:MenuAddElem(L);
3:MenuFindElem(L);
4:MenuAlterElem(L);
5:MenuDleteElem(L);
6:MenuDisplayElem(L);

1.创建新的通讯录
2.增加联系人

3.查找联系人(详细)
3.查找联系人(界面)

4.修改联系人(查找部分)
4.修改联系人(修改部分)
4.修改联系人(界面部分)

5.删除联系人(查找部分)
5.删除联系人(界面部分)

6.显示联系人
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

//1.创建新的通讯录
void MenuCreatList(ElemList & L)
{
	if (L.head!=NULL)
	{
		cout<<"已有通讯录，确定要重新创建?(y/n)";
		if (Y_N()==0)
			return;
	}
	CreatElemList(L);
	cout<<"是否需要添加元素?(y/n)";
	if (Y_N())
	{
		cout<<"请输入添加的个数:";
		int n;
		cin>>n;
		for (int i=1;i<=n;i++)
		{
			cout<<"联系人"<<i<<":"<<endl;
			MenuAddElem(L);
		}
	}
	cout<<"创建成功!"<<endl;
	SaveElemList(L);
	getchar();
}

//2.增加联系人
void MenuAddElem(ElemList & L)
{
	Elem t;
	cout<<"姓名:";	cin>>t.name;
	t.word=Get_Head_Word(t.name);
	int n;
	cout<<"手机号个数为:(0/1/2)";cin>>n;
	if (n==0) 
	{
		strcpy(t.phone1,"无");
		strcpy(t.phone2,"无");
	}
	for (int i=1;i<=n;i++)
	{
		if (i==1)
		{
			cout<<"手机号"<<i<<":";
			cin>>t.phone1;
			strcpy(t.phone2,"无");
		}
		if (i==2)
		{
			cout<<"手机号"<<i<<":";
			cin>>t.phone2;
		}
		if (i>=3)
		{
			cout<<"最多添加 2 个手机号."<<endl;
			break;
		}
	}
	cout<<"是否填写QQ:(y/n)";
	strcpy(t.qq,"无");
	if (Y_N())
	{
		cout<<"QQ:";
		cin>>t.qq;
	}
	cout<<"确认添加?(y/n)";
	if (Y_N())
	{
		AddElem(L,&t);
		cout<<"添加成功!"<<endl;
		getchar();getchar();
	}
	SaveElemList(L);
}

//3.查找联系人(详细)
void MenuFind_KindElem(ElemList & L,int op)
{
	cout<<"请输入要查找的联系人的";
	switch(op)
	{
	case 1:cout<<"姓名:";break;
	case 2:cout<<"手机号:";break;
	case 3:cout<<"QQ号:";break;
	}
	char go[20];
	cin>>go;
	if (op==3) op=4;//3 留了出来，特殊情况
	Elem * pos = FindElem(L,go,op);
	if (pos==NULL)
	{
		cout<<"无此联系人!"<<endl;
	}
	else
	{
		cout<<"-------------------------------------------------------------"<<endl;
		printf("%-12s %-16s %-16s %-16s\n","姓名","手机号1","手机号2","QQ");
		cout<<"-------------------------------------------------------------"<<endl;
		printf("%-12s %-16s %-16s %-16s\n",pos->name,pos->phone1,pos->phone2,pos->qq);
		cout<<"-------------------------------------------------------------"<<endl;
	}
}

//3.查找联系人(界面)
void MenuFindElem(ElemList & L)
{
	system("CLS");

	cout<<"\t\t--------查找--------"<<endl;
	cout<<"\t\t请输入查找的方式:"<<endl;
	cout<<"\t\t1.姓名"<<endl;
	cout<<"\t\t2.手机号"<<endl;
	cout<<"\t\t3.QQ"<<endl;
	cout<<"\t\t4.退出"<<endl;
	cout<<"\t\t--------------------"<<endl;
	cout<<"请选择:";
	int op; 
	cin>>op;
	if (op==4) return ;
	if (op>=1&&op<=3)
		MenuFind_KindElem(L,op);
	else
		cout<<"输入错误!"<<endl;
	getchar();getchar();
}

//4.修改联系人(查找部分)
Elem * MenuAlter_FindElem(ElemList & L)
{
	system("CLS");
	cout<<"\t\t--------搜索--------"<<endl;
	cout<<"\t\t请输入搜索的方式:"<<endl;
	cout<<"\t\t1.按姓名搜索"<<endl;
	cout<<"\t\t2.按手机号搜索"<<endl;
	cout<<"\t\t3.按QQ搜索"<<endl;
	cout<<"\t\t--------------------"<<endl;
	cout<<"请选择:";
	int op;
	cin>>op;
	while (1)
	{
		if (op>=1&&op<=3)
		{
			cout<<"请输入要查找的联系人的";
			switch(op)
			{
			case 1:cout<<"姓名:";break;
			case 2:cout<<"手机号:";break;
			case 3:cout<<"QQ号:";break;
			}
			char go[20];
			cin>>go;
			if (op==3) op=4;//3 留了出来，特殊情况
			return FindElem(L,go,op);
		}
		else
			cout<<"输入错误!"<<endl;
	}
	return NULL;
}

//4.修改联系人(修改部分)
int MenuXiuGaiElem(Elem * pos)
{
	system("CLS");
	cout<<"------------------修改此联系人一项数据------------------"<<endl;
	printf("%-12s %-16s %-16s %-16s\n","姓名","手机号1","手机号2","QQ");
	printf("%-12s %-16s %-16s %-16s\n",pos->name,pos->phone1,pos->phone2,pos->qq);
	cout<<"--------------------------------------------------------"<<endl;
	cout<<"需要修改的是:"<<endl;
	cout<<"1.姓名"<<endl;
	cout<<"2.手机号1"<<endl;
	cout<<"3.手机号2"<<endl;
	cout<<"4.QQ"<<endl;
	cout<<"--------------------------------------------------------"<<endl;
	cout<<"请选择:";
	int op;
	cin>>op;
	cout<<"修改为:";
	char k[20];
	cin>>k;
	switch (op)
	{
	case 1:strcpy(pos->name,k);pos->word=Get_Head_Word(pos->name);break;
	case 2:strcpy(pos->phone1,k);break;
	case 3:strcpy(pos->phone2,k);break;
	case 4:strcpy(pos->qq,k);break;
	default:cout<<"输入错误!"<<endl;
	}
	return 1;
}

//4.修改联系人(界面部分)
void MenuAlterElem(ElemList & L)
{
	Elem * pos =  MenuAlter_FindElem(L);
	if (pos==NULL)
	{
		cout<<"该联系人不存在!"<<endl;
	}
	else
	{
		while (1)
		{
			MenuXiuGaiElem(pos);
			cout<<"继续修改此联系人?(y/n)";
			if (!Y_N())
				break;
		}
		cout<<"修改完成!"<<endl;
		SaveElemList(L);
	}
	getchar();getchar();
	return;
}

//5.删除联系人(查找部分)
Elem * MenuDelete_FindElem(ElemList & L)
{
	system("CLS");
	cout<<"\t\t--------搜索--------"<<endl;
	cout<<"\t\t请输入搜索的方式:"<<endl;
	cout<<"\t\t1.按姓名搜索"<<endl;
	cout<<"\t\t2.按手机号搜索"<<endl;
	cout<<"\t\t3.按QQ搜索"<<endl;
	cout<<"\t\t--------------------"<<endl;
	cout<<"请选择:";
	int op;
	cin>>op;
	while (1)
	{
		if (op>=1&&op<=3)
		{
			cout<<"请输入要查找的联系人的";
			switch(op)
			{
			case 1:cout<<"姓名:";break;
			case 2:cout<<"手机号:";break;
			case 3:cout<<"QQ号:";break;
			}
			char go[20];
			cin>>go;
			if (op==3) op=4;//3 留了出来，特殊情况
			return FindElem(L,go,op);
		}
		else
			cout<<"输入错误!"<<endl;
	}
	return NULL;
}

//5.删除联系人(界面部分)
void MenuDleteElem(ElemList & L)
{
	Elem * pos = MenuDelete_FindElem(L);
	if (pos==NULL)
	{
		cout<<"未找到此联系人!";
		getchar();getchar();
		return ;
	}
	cout<<"------------------该联系人数据--------------------------"<<endl;
	printf("%-12s %-16s %-16s %-16s\n","姓名","手机号1","手机号2","QQ");
	printf("%-12s %-16s %-16s %-16s\n",pos->name,pos->phone1,pos->phone2,pos->qq);
	cout<<"--------------------------------------------------------"<<endl;
	cout<<"确认删除?(y/n)";
	if (Y_N())
	{
		 DeleteElem(L,pos);
		 cout<<"删除成功!"<<endl;
		 SaveElemList(L);
		 getchar();getchar();
		 return;
	}
}

//6.显示联系人
void MenuDisplayElem(ElemList & L)
{
	system("CLS");
	if (!DisplayElemList(L))
		cout<<"联系人为空!"<<endl;
	getchar();getchar();
}


//联系人排序
void MenuSortElemList(ElemList &L)
{
	if (L.head==NULL)
	{
		cout<<"联系人为空!"<<endl;
		getchar();getchar();
		return ;
	}
	SortElemList(L);
	cout<<"按名称顺序排序结果:"<<endl;
	DisplayElemList(L);
	cout<<"是否保存?(y/n)";
	if (Y_N())
	{
		SaveElemList(L);
		cout<<"保存成功!"<<endl;
		getchar();getchar();
		return ;
	}
	LoadElemList(L);
}