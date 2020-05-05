import { Organization } from './organization';
import { Domain } from './domain';
import { Position } from './position';

export class Structure{
    id: number;
    org: number;
    dm: number;
    level0Id: number;
    level1Id: number;
    level2Id: number;
    level3Id: number;
    level4Id: number;
    level5Id: number;
    level6Id: number;
    level7Id: number;
    orgObj: Organization;
    dmObj: Domain;
    level0Obj: Position;
    level1Obj: Position;
    level2Obj: Position;
    level3Obj: Position;
    level4Obj: Position;
    level5Obj: Position;
    level6Obj: Position;
    level7Obj: Position;
}