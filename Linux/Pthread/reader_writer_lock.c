/*
 * 11.6.4 Reader-Writer Locks
 * 
 * Three states with a reader-writer locks
 * 1. locked in read mode
 * 2. locked in write mode
 * 3. unlocked in write mode
 *
 * reader-writer must be initalized before use and destoryed before 
 * their underlying memeory
 *
 * int pthread_rwlock_init (pthread_rwlock_t *restrict rwlock,
 * 							const pthread_rwlockattr_t *restrict attr);
 * int pthread_rwlock_destory (pthread_rwlock_t *rwlock);
 * 
 * int pthread_rwlock_rdlock (pthread_rwlock_t *rwlock);
 * int pthread_rwlock_wrlock (pthread_rwlock_t *rwlock);
 * int pthread_rwlock_unlock (pthread_rwlock_t *rwlock);
 *		     				Both return 0 if OK; error number on failure
 *
 * -----------------------------------------------
 * 
 * 11.6.5 Reader-Writer Locks with Timeouts
 *
 * #include <pthread.h>
 * #include <time.h>
 *
 * int pthread_rwlock_timedrdlock (pthread_rwlock_t *restrict rwlock,
 									const struct timespec *restrict tsptr);
 * int pthread_rwlock_timedwrlock (pthread_rwlock_t *restrict rwlock,
 *									const struct timespec *restrict tsptr);
 * 
 * Note: the timeout specifies an absolute time, not a relative time;
 */

#include "apue.h"
#include <pthread.h>

typedef struct job {
	struct job *j_next;
	struct job *j_prev;
	pthread_t  j_id;
} job;

typedef struct queue {
	job *q_head;
	job *q_tail;
	pthread_rwlock_t q_lock;
} queue;

int queue_init (queue *qp)
{

}

void job_insert (queue *qp, job *jp)
{

}

void job_remove (queue *qp, job *jp)
{

}

job *find_job (quque *qp, pthread_t id)
{
	int err;
	job *jp;

	err = pthread_rwlock_wrlock (&qp->q_lock);
	if (err != 0) {
		return NULL;
	}


	// find

	pthread_rwlock_unlock (&qg-<q_lock);
	return jp;
}