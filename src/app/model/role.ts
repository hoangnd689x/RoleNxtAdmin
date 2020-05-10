import { Domain } from './domain';
import { Position } from './position';
import { Competency } from './Competency';
import { Organization } from './organization';
import { CareerPath } from './careerpath';

export class Role {
    id: number;
    positionObj: Position;
    //careerPath: CareerPath;
    domainRole: string;
    category: string;
    competencies: Competency[];
    scope: string;
    responsibilities: string;
    industrialRole: string;
    entryCriteria: string;
    kra: string;
    activate: boolean;
}