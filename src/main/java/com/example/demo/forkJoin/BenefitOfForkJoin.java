package com.example.demo.forkJoin;

public class BenefitOfForkJoin {
    /**
     * 1. efficient parallelism:
     *      the fork/join framework is designed for efficient parallelism,
     *      allowing the workload to be divded into smaller subtasks that can be executed in
     *      parallel. this is achieved by recursiveling splitting the workload until each subtask can be
     *      executed independently. this can result in significant performance improvements
     *      for CPU-bound tasks.
     * 2. load balancing:
     *      the fork/join framework automatically balances the workload across available threads, ensuring
     *      that each thread has roughly the same amount of work to do. this helps ot avoid situations where
     *      some threads are idle while others are overloaded, leading to suboptimal performance
     *  3. recursive algorithms:
     *      the fork/join framework is particularly well-suited for recursive algorithms,
     *      such as sorting, searching, and tree traversal. these algorithms typically involve dividing the
     *      problems into smaller subproblems and combining the results. the fork/join framework provides a
     *      natural way to implement this type of algorithm by recursively dividing the problem into subtasks
     *  4. simple API:
     *      the fork/join framework provides a simple and intuitive API for parallel programming in java. this
     *      makes it easy for developer to parallelize their code without having to deal with low-level details
     *      such as thread synchronization and locking
     * 5. integraiton with other java APIs:
     *      the fork/join framework is integrated with other java APIs, such as the Stream API and the
     *      CompletableFuture API, making it easy to write parallel code that integrates with other java libraries
     */
}
