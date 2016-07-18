/*
 * 线程终止的三个方式
 * 1. 简单的 return
 * 2. 线程被同一进程中的其他线程取消
 * 3. 线程自身调用 pthread_exit
 * 
 * 线程连接
 * int pthread_join(pthread_t thread, void **rval_ptr);
 * 调用该方法的线程将会阻塞, 直到指定线程thread
 * 1. 调用了pthread_exit : 返回码
 * 2. 从启动历程中返回 : 返回码
 * 3. 被取消 : 参数设置为  PTHREAD_CANCELED
 */

#include "apue.h"
#include <pthread.h>

void * pthreadF (void *arg)
{
	printf ("thread 1 returning\n");

	return ((void *) 1 );
}

void * pthreadS (void *arg)
{
	printf ("thread 2 returning\n");

	return ((void *) 2 );
}

int main(void)
{
	int err;
	pthread_t tidF, tidS;

	void *tret;   // join return value

	err = pthread_create(&tidF, NULL, pthreadF, NULL);
	if (err != 0) {
		err_exit(err, "can't create thread 1");
	}

	err = pthread_create(&tidS, NULL, pthreadS, NULL);
	if (err != 0) {
		err_exit(err, "can't create thread 2");
	}
	// 获取线程退出状态
	err = pthread_join (tidF, &tret);
	if (err != 0) {
		err_exit(err, "can't join with thread 1");
	}

	printf ("pthread 1 exit code %ld\n", (long) tret);

	err = pthread_join (tidS, &tret);
	if (err != 0) {
		err_exit(err, "can't josin with thread 2");
	}

	printf ("pthread 2 exit code %ld\n", (long) tret);

	exit(0);
}

