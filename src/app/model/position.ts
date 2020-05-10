import { Domain } from './domain';
import { Organization } from './organization';
import { CareerPath } from './careerpath';

export class Position {
    id: number;
    organizationObj: Organization;
    careerpathObj: CareerPath;
    name: string;
    cluster: number;
    activate: boolean;
}