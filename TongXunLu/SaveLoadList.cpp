#include "Node.h"
/*
1.���������ļ�
2.���ļ���ȡ����
*/

//���������ļ�
int SaveElemList(ElemList & L)
{
	ofstream out("TTT");
	if (L.head==NULL) return OK;
	Elem * cur = L.head;
	Elem * next= cur->Next;
	while (next)
	{
		out<<cur->name<<' ';
		out<<cur->word<<' ';
		out<<cur->phone1<<' ';
		out<<cur->phone2<<' ';
		out<<cur->qq<<endl;
		cur=next;
		next=next->Next;
	}
	out<<cur->name<<' ';
	out<<cur->word<<' ';
	out<<cur->phone1<<' ';
	out<<cur->phone2<<' ';
	out<<cur->qq;
	out.close();
	return OK;
}

//���ļ���ȡ����
int LoadElemList(ElemList & L)
{
	L.head=NULL;
	L.num=0;
	ifstream in("TTT");
	Elem * cur,* next;
	while (!in.eof())
	{
		next=new(Elem);
		if (!(in>>next->name)) break;
		in>>next->word;
		in>>next->phone1;
		in>>next->phone2;
		in>>next->qq;
		if (L.head==NULL)
		{
			L.head=next;
			cur=next;
			L.num++;
			continue;
		}
		cur->Next=next;
		cur=next;
		L.num++;
	}
	in.close();
	return OK;
}