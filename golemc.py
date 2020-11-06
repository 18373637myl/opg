#!/usr/bin/env python3
import py_compile
import argparse


def parse_args():
    p = argparse.ArgumentParser(description='A mock bytecode compiler.')
    p.add_argument('source')
    p.add_argument('-o', '--out', default=None)

    args = p.parse_args()
    return args


def compile(file, out=None):
    py_compile.compile(file, cfile=out)


def main():
    a = parse_args()
    compile(a.source, out=a.out)


if __name__ == "__main__":
    main()
