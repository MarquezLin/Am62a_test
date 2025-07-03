// hello.c
#include <linux/module.h>
#include <linux/init.h>

MODULE_LICENSE("GPL");
MODULE_AUTHOR("Your Name");
MODULE_DESCRIPTION("A simple Hello World kernel module");

static int __init hello_init(void)
{
    pr_info("Hello, AM62A world from kernel!\n");
    return 0;
}

static void __exit hello_exit(void)
{
    pr_info("Goodbye, AM62A world!\n");
}

module_init(hello_init);
module_exit(hello_exit);
