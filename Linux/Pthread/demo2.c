/*
 * gcc -Wall -I../apue/include demo2.c -o demo2 -pthread -L../apue/lib -lapue
 * 
 * A thread can arrange for functions to be called when it exits.
 * 
 * void pthread_cleanup_push (void (*rtn)(void *), void *arg);
 * void pthread_cleanup_pop (int execute);
 * 
 * ----------------------------
 *
 * The 'clean up' function will be schedules with the single argument, when
 * the the thread perfoms one of the following action:
 * 1. makes a call to pthread_exit
 * 2. responds to a cancellation request
 * 3. makes a call to pthread_clean_pop with a nonzero execute argument
 * 
 */
#include "apue.h"
#include <pthread.h>

void cleanup(void *arg)
{
	printf ("cleanup: %s\n", (char *) arg);
}

void *thr_fn1(void *arg)
{
	puts ("thread 1 start");

	pthread_cleanup_push (cleanup, "thread 1 first handler");
	pthread_cleanup_push (cleanup, "thread 1 second handler");

	if (arg) {
		return ((void *) 1);
	}

	pthread_cleanup_pop (0);
	pthread_cleanup_pop (0);

	return ((void *) 1);
}

void *thr_fn2(void *arg)
{
	puts ("thread 2 start");

	pthread_cleanup_push (cleanup, "thread 2 first handler");
	pthread_cleanup_push (cleanup, "thread 2 second handler");

	if (arg) {
		pthread_exit ((void *) 2);
	}

	pthread_cleanup_pop (0);
	pthread_cleanup_pop (0);

	pthread_exit ((void *) 2);
}

int main(void)
{
	int err;
	pthread_t tid1, tid2;
	void *tret;

	err = pthread_create(&tid1, NULL, thr_fn1, (void *)1);
	if (err != 0) {
		err_exit(err, "can't create thread 1");
	}	

	err = pthread_create(&tid2, NULL, thr_fn2, (void *)1);
	if (err != 0) {

	}

	err = pthread_join(tid1, &tret);
	if (err != 0) {

	}
	printf ("thread 1 exit code %ld\n", (long) tret);

	err = pthread_join(tid2, &tret);
	if (err != 0) {

	}
	printf ("thread 2 exit code %ld\n", (long) tret);

	exit (0);
}