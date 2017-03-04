#include "MenuFunc.cpp"


//菜单
void Menu(ElemList & L)
{
	LoadElemList(L);
	while (1)
	{
		system("CLS");
		cout<<"\t\t--------菜单--------"<<endl;
		cout<<"\t\t1.创建新的通讯录"<<endl;
		cout<<"\t\t2.增加联系人"<<endl;
		cout<<"\t\t3.查找联系人"<<endl;
		cout<<"\t\t4.修改联系人"<<endl;
		cout<<"\t\t5.删除联系人"<<endl;
		cout<<"\t\t6.显示联系人"<<endl;
		cout<<"\t\t7.联系人排序"<<endl;
		cout<<"\t\t8.退出"<<endl;
		cout<<"\t\t--------------------"<<endl;
		cout<<"请选择:";
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
		default:cout<<"输入错误,请重新输入!"<<endl;
			getchar();getchar();
		}
	}
	return;
}

void Quit(ElemList & L)//退出
{
	cout<<"确认退出?(y/n)";
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
		cout<<"\t\t--------通讯录--------"<<endl;
		cout<<"\t\t1.菜单"<<endl;
		cout<<"\t\t2.退出"<<endl;
		cout<<"\t\t----------------------"<<endl;
		cout<<"请选择:";
		int op;
		cin>> op;
		switch(op)
		{
		case 1:
			Menu(L);break;
		case 2:
			Quit(L);break;
		default:cout<<"输入错误,请重新输入!"<<endl;
			getchar();getchar();
		}
	}
	return 0;
}