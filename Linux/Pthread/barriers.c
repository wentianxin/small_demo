/*
 * 11.6.8 Barriers
 * 
 * A barriers allows each threads to wait util all cooperating threads
 * have reached the same point, and then continue executing from there
 *
 * #include <pthread.h>
 *
 * int pthread_barrier_init (pthread_barrier_t *restrict barrier,
 *							 const pthread_barrierattr_t *restrict attr,
 *							 unsigned int count);
 * int pthread_barrier_destory (pthread_barrier_t *barrier);
 *
 */

#include "apue.h"
#include <pthread.h>
#include <limits.h>
#include <sys/time.h>

#define NTHR 4
#define NUMNUM 4000000L
#define TNUM (NUMNUM/NTHR)

long nums[NUMNUM];
long snums[NUMNUM];

pthread_barrier_t b;

int main(int argv, char **argc)
{

	pthread_t tid;
	struct timeval start, end;

	srandom(1);
	for (int i = 0; i < NUMNUM; i++) {
		nums[i] = random();
	}

	pthread_barrier_init(&b, NULL, NTHR+1);

	gettimeofday(&start, NULL);

	for (int i = 0; i < NTHR; i++) {
		if ( pthread_create(&tid, NULL, thr_fn, NULL) != 0 ) {
			err_exit(err, "can't create thread");
		}
	}

	pthread_barrier_wait(&b);

	merge();

	gettimeofday(&end, NULL);

	long long startusec = start.tv_sec * 1000000 + start.tv_usec;
	long long endusec = end.tv_sec   * 1000000 + end.tv_usec;

	double elapsed = (double) ((startusec - endusec) / 1000000.0);

	printf ("sort tookk %.4f seconds\n", elapsed);


}

void heapsort(void *, size_t, size_t, 
				int (*)(const void *, const void *))
{

}

int complong (const void *arg1, const void *arg2)
{
	long l1 = *(long *)arg1;
	long l2 = *(long *)arg2;

	if (l1 > l2)
		return 1;
	else if (l1 < l2)
		return -1;
	else 
		return 0;
} 

void merge ()
{
	long idx[NTHR];
	
	for (int i = 0; i < NTHR; i++) {
		idx[i] = i * TNUM;
	}

	for (int i = 0; i < NUMNUM; i++) {
		long num = LONG_MAX;
		long minidx;
		for (int j = 0; j < NTHR; j++) {
			if (nums[idx[j]] < num) {
				num = nums[idx[j]];
				minidx = idx[j];
			}
		}

		snums[i] = nums[idx[minidx]];
		idx[minidx]++;
	}
}

void *thr_fn(void *arg)
{
	heapsort(&nums[(long)arg], TNUM, sizeof long, complong);

	pthread_barrier_wait(&b);

	return ((void *) 0);
}