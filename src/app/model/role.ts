import { Domain } from './domain';
import { Position } from './position';
import { Competency } from './Competency';
import { Organization } from './organization';

export class Role {
    id: number;
    domain: number;
    domainObj: Domain;
    careerPath: string;
    position : number;
    positionObj: Position;
    org: string;
    orgObj: Organization;
    domainRole: string;
    category: string;
    competency: string;
    competencyObj: Competency[];
    scope: string;
    responsibilities: string;
    industrialRle: string;
    entryCriteria: string;
    kra: string;
}