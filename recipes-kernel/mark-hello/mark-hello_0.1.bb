DESCRIPTION = "Simple Hello kernel module"
PN = "mark-hello"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7e4cfe1c8dee5c6fe34c79c38d7b6b52"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "file://hello.c file://Makefile file://LICENSE"

S = "${WORKDIR}"

inherit module

PN = "mark-hello"

# do_compile() {
#     make -C ${KERNEL_SRC} M=${S} modules
# }

do_install() {
    install -d ${D}/usr/lib/modules/${KERNEL_VERSION}/extra
    install -m 0644 hello.ko ${D}/usr/lib/modules/${KERNEL_VERSION}/extra/

    install -d ${D}${sysconfdir}/modules-load.d
    echo "hello" > ${D}${sysconfdir}/modules-load.d/hello.conf
}

FILES:${PN} += "/usr/lib/modules/*/extra/hello.ko"
FILES:${PN} += "/etc/modules-load.d/hello.conf"


# FILES_${PN} += " \
#     /lib/modules/${KERNEL_VERSION}/extra/hello.ko \
#     /etc/modules-load.d/hello.conf \
# "
