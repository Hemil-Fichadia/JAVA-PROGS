public class ProcessessAndThreads {
    /* When we download any application, we actually download the
    .exe file for windows operating system, similarly for android it
    is .apk file and for mac it is .dmg file that means we don't actually
    download the source code and start running it, it's actually a build
    file that is generated after source code is compiled, so it's concise
    version of whole source code.

    This build file or say .exe file is stored in our device's Hard Drive disk
    (HDD) and hard drives are slow compared to CPUs as each core of CPU have
    execution order of 10^9 cycles per second and due to this speed difference,
    when we run that application, Operating system takes whole program to RAM
    and then CPU deals from RAM.

    In Google Docs, when we are working in a document, functionalities like
    auto save, spell check, grammar check happens in parallel so this a use-case
    of multi threading and when we run a program it becomes a process and inside
    that process there are multiple threads/execution units inside it and for
    each task we need to have a thread so as many tasks, that many threads are
    required.

    Process:-
    when we run an application, it becomes a process and inside that process
    there can be multiple threads means multiple operations happening at a time
    so a process can have multiple files, data members, behaviours, stack memory,
    heap memory but a thread is the actual execution unit of a process.

    Thread :-
    It is execution unit of CPU and executes a thread.
    It is also known as a lightweight execution of a process.
    So whenever any program is running, then there are multiple
    things happening at a time like spell check, auto save etc.
    this each thing becomes a thread and  CPU executes that thread
    and that thread executes that code which is responsible for
    carrying out certain operations at a time.

    So when an application is running it is under control by a Process Control
    Block that have data, files, resources and a Program Counter that keeps track of
    till which line of code in a file has been executed.
    In a process there are multiple threads running so each of threads share common code
    base, files and resource to execute those tasks but some tasks like program counter
    are kept thread specific as each thread will be executing its own piece of code so
    it require its own program counter.

    The difference between process and thread is a thread can have multiple shared
    data or resource but a process can't have something in shared.
    * */
}
