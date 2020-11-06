#!/usr/bin/env python3
import subprocess as sp
import argparse


def parse_args():
    p = argparse.ArgumentParser(description='A mock bytecode interpreter.')

    p.add_argument('pyc')
    p.add_argument('args', type=str, nargs='*')

    args = p.parse_args()
    return args


def run(pyc, args):
    if not pyc.endswith('.pyc'):
        raise NotImplementedError('Expected a .pyc file.')
    sp.check_call(["python", pyc] + args)


def main():
    a = parse_args()
    run(a.pyc, a.args)


if __name__ == "__main__":
    main()
